import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { PersonType } from '../model/person.type.model';
import { State } from '../model/state.model';
import { StatesService } from '../services/states.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup

  cpfCnpjPattern = /(^\d{3}\.\d{3}\.\d{3}\-\d{2}$)|(^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$)/

  personsType: PersonType[] = [
    {value: 'pf', label: 'Doador'},
    {value: 'pj', label: 'Instituição'}
  ]

  states: State[]

  constructor(private formBuilder: FormBuilder, private statesService: StatesService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstname: this.formBuilder.control('',[Validators.required, Validators.minLength(3)]),
      lastname: this.formBuilder.control('',[Validators.required, Validators.minLength(3)]),
      personType: this.formBuilder.control('',[Validators.required]),
      email: this.formBuilder.control('', [Validators.required, Validators.email]),
      cpfCnpj: this.formBuilder.control('',[Validators.required, Validators.pattern(this.cpfCnpjPattern)]),
      uf: this.formBuilder.control('', [Validators.required]),
      city: this.formBuilder.control('',[Validators.required]),
      bloodType: this.formBuilder.control('',[Validators.required]),
      password: this.formBuilder.control('',[Validators.required, Validators.minLength(6)]),
      confirmPassword: this.formBuilder.control('', [Validators.required, Validators.minLength(6)]),
    }, {validator: RegisterComponent.equalsTo})

    this.statesService.getStates().subscribe((res: any) => {
      console.log(res)
      // this.states = res
    });
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

}
