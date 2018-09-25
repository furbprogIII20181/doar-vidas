import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms'
import { State } from '../model/state.model';
import { StatesService } from '../services/states.service';
import { BloodType } from '../model/blood.type.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup

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

  statesObject: Array<State>

  constructor(private formBuilder: FormBuilder, private statesService: StatesService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstname: this.formBuilder.control('',[Validators.required, Validators.minLength(3)]),
      lastname: this.formBuilder.control('',[Validators.required, Validators.minLength(3)]),
      personType: this.formBuilder.control('D',[Validators.required]),
      email: this.formBuilder.control('', [Validators.required, Validators.email]),
      cellphone: this.formBuilder.control('',[Validators.required, Validators.minLength(11), Validators.maxLength(11)]),
      cpfCnpj: this.formBuilder.control('',[Validators.required]),
      uf: this.formBuilder.control('', [Validators.required]),
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
      } else {
        this.registerForm.get('cpfCnpj').setValidators(Validators.pattern(this.cnpjPattern))
      }
    });
  }

  getStates(): void {
    this.statesService.getStates().subscribe(response => this.statesObject = {... response})
  }
}
