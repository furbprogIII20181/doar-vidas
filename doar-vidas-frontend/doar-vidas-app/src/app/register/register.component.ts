import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms'
import { State } from '../model/state.model';
import { StatesService } from '../services/states.service';
import { BloodType } from '../model/blood.type.model';
import { RegisterService } from '../services/register.service';
import { Donator } from '../model/donator.model';
import { Institution } from '../model/institution.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup

  hidePass = true;
  hideCPass = true;

  cnpjPattern = /(^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$)/

  cpfPattern = /(^\d{3}\.\d{3}\.\d{3}\-\d{2}$)/

  bloodTypes: BloodType[] = [
    {code: 'APOS', description: 'A+'},
    {code: 'ANEG', description: 'A-'},
    {code: 'BPOS', description: 'B+'},
    {code: 'BNEG', description: 'B-'},
    {code: 'ABPOS', description: 'AB+'},
    {code: 'ABNEG', description: 'AB-'},
    {code: 'OPOS', description: 'O+'},
    {code: 'ONEG', description: 'O-'}
  ]

  labelCpf = "* Cpf"

  labelName = "* Nome"

  labelLastname = "* Sobrenome"

  statesObject: Array<State>

  constructor(private formBuilder: FormBuilder, private statesService: StatesService, private registerService: RegisterService,private location: Location) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      name: this.formBuilder.control('',[Validators.required, Validators.minLength(3)]),
      lastName: this.formBuilder.control('',[Validators.required, Validators.minLength(3)]),
      personType: this.formBuilder.control('D',[Validators.required]),
      email: this.formBuilder.control('', [Validators.required, Validators.email]),
      phone: this.formBuilder.control('',[Validators.required, Validators.minLength(11), Validators.maxLength(11)]),
      cpfCnpj: this.formBuilder.control('',[Validators.required]),
      state: this.formBuilder.control('', [Validators.required]),
      city: this.formBuilder.control('',[Validators.required]),
      bloodType: this.formBuilder.control('',[Validators.required]),
      password: this.formBuilder.control('',[Validators.required, Validators.minLength(6)]),
      confirmPassword: this.formBuilder.control('', [Validators.required, Validators.minLength(6)]),
    }, {validator: RegisterComponent.equalsTo})
    
    this.getStates()
    this.onChanges()
  }

  static equalsTo(group: AbstractControl): {[key:string]: boolean} {
    const password = group.get('password')
    const passwordConfirmation = group.get('confirmPassword')

    if (!password || !passwordConfirmation) {
      return undefined
    }

    if (password.value !== passwordConfirmation.value) {
      return {passwordsNotMatch:true}
    }

    return undefined
  }

  onChanges(): void {
    this.registerForm.get('personType').valueChanges.subscribe(val => {
      if (val == 'D') {
        this.registerForm.get('cpfCnpj').setValidators(Validators.pattern(this.cpfPattern))
        this.labelCpf = "* Cpf"
        this.labelName = "* Nome"
        this.labelLastname = "* Sobrenome"
      } else {
        this.registerForm.get('cpfCnpj').setValidators(Validators.pattern(this.cnpjPattern))
        this.labelCpf = "* Cnpj"
        this.labelName = "* Nome Fantasia"
        this.labelLastname = "* Razão Social"
      }
    });
  }

  getStates(): void {
    this.statesService.getStates().subscribe(response => this.statesObject = {... response})
  }

  onSubmit() {
    let cpfCnpj = this.registerForm.get('cpfCnpj').value
    this.registerForm.get('cpfCnpj').setValue(cpfCnpj.replace(/\D/g,''))
    if (this.registerForm.get('bloodType').value.length) {
      this.registerDonator(this.registerForm.value)
    } else {
      this.registerInstitution(this.registerForm.value)
    }
    return false
  }

  registerDonator(donator: Donator) {
    this.registerService.registerDonator(donator).subscribe(response => {
      console.log(response,this.registerForm.get('email'),this.registerForm.get('password'))
    })
  }

  registerInstitution(institution: Institution) {
    
  }

  cancel() {
    this.location.back(); // <-- go back to previous location on cancel
  }
}
