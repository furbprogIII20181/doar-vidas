import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { GlobalService } from '../../services/global.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MyUser } from '../../model/myuser.model';
import { StatesService } from '../../services/states.service';
import { State } from '../../model/state.model';
import { BloodType } from '../../model/blood.type.model';
import { Location } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

  user: MyUser;
  editForm: FormGroup
  statesObject: Array<State>
  userState: any
  personId: number

  labelCpf = "* Cpf"

  labelName = "* Nome"

  labelLastname = "* Sobrenome"

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

  constructor(
    private userService: UserService,
    private globalService: GlobalService,
    private formBuilder: FormBuilder,
    private statesService: StatesService,
    private location: Location,
    private router: Router
  ) { }

  ngOnInit() {
    if (!this.globalService.getIsLoggedin()) {
      this.router.navigate(['/login'])
    }
    this.getStates()
    this.editForm = this.formBuilder.group({
      id: this.formBuilder.control(this.getPersonId(),[Validators.required]),
      name: this.formBuilder.control({value:'', disabled: true},[Validators.required, Validators.minLength(3)]),
      lastName: this.formBuilder.control({value:'', disabled: true},[Validators.required, Validators.minLength(3)]),
      email: this.formBuilder.control({value:'', disabled: true}, [Validators.required, Validators.email]),
      phone: this.formBuilder.control('',[Validators.required, Validators.minLength(11), Validators.maxLength(11)]),
      cpfCnpj: this.formBuilder.control({value:'', disabled: true},[Validators.required]),
      state: this.formBuilder.control('', [Validators.required]),
      city: this.formBuilder.control('',[Validators.required]),
      bloodType: this.formBuilder.control({value:'', disabled: true},[Validators.required]),
      description: this.formBuilder.control('',[Validators.required])
    })

  }

  getPersonId() {
    return JSON.parse(localStorage.getItem('user_info')).id
  }

  getStates(): void {
    this.statesService.getStates().subscribe(
      response => {
        this.statesObject = {... response}
        this.getUserInfo()
      },
      (error) => this.globalService.handleError(error))
  }

  getUserInfo (){
    if (this.globalService.getIsLoggedin()) {
      let id = JSON.parse(localStorage.getItem('user_info')).id;
      this.userService
        .getUserInfo(id)
        .subscribe(
          response => {
            this.user = response
            this.populateForm()
          },
          (error) => this.globalService.handleError(error)
        )
    }
  }

  populateForm () {
    this.editForm.get('name').setValue(this.user.name)
    this.editForm.get('lastName').setValue(this.user.lastName)
    this.editForm.get('cpfCnpj').setValue(this.user.cpfCnpj)
    this.editForm.get('state').setValue(this.user.state)
    this.editForm.get('city').setValue(this.user.city)
    this.editForm.get('bloodType').setValue(this.user.bloodType)
    this.editForm.get('email').setValue(this.user.email)
    this.editForm.get('description').setValue(this.user.description)
    this.editForm.get('phone').setValue(this.user.phone)
  }

  onSubmit() {
    if (this.editForm.valid) {
      const id = JSON.parse(localStorage.getItem('user_info')).id
      this.userService.updateUserInfo(this.editForm.value, id)
        .subscribe(
          response => {
            this.globalService.handleSuccess(`Alterações salvas com sucesso`)
            this.back()
          },
          error => this.globalService.handleError(error)
        )
    }
  }

  back() {
    this.location.back();
  }

}
