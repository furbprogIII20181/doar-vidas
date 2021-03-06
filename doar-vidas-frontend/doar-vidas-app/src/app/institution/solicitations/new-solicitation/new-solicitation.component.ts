import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GlobalService } from '../../../services/global.service';
import { SolicitationsService } from '../../../services/solicitations.service';
import { Location } from '@angular/common';
import { BloodType } from '../../../model/blood.type.model';

@Component({
  selector: 'app-new-solicitation',
  templateUrl: './new-solicitation.component.html',
  styleUrls: ['./new-solicitation.component.css']
})
export class NewSolicitationComponent implements OnInit {

  newSolicitationForm: FormGroup

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
    private formBuilder: FormBuilder,
    private globalService: GlobalService,
    private solicitationsService: SolicitationsService,
    private location: Location
  ) { }

  ngOnInit() {
    this.newSolicitationForm = this.formBuilder.group({
      institutionID: this.formBuilder.control(JSON.parse(localStorage.getItem('user_info')).id,[Validators.required]),
      bloodType: this.formBuilder.control('',[Validators.required]),
      quantity: this.formBuilder.control('',[Validators.required])
    })
  }

  back() {
    this.location.back(); // <-- go back to previous location on cancel
  }

  onSubmit() {
    if (this.newSolicitationForm.valid) {
      let qty = parseFloat(this.newSolicitationForm.get('quantity').value)

      if (!isNaN(qty) && qty > 0) {
        this.solicitationsService.saveSolicitation(this.newSolicitationForm.value)
        .subscribe(
          (data) => {
            this.globalService.handleSuccess(`Solicitação de doação do sangue tipo ${this.globalService.convertBloodType(data.bloodType)} foi salva.`)
            this.back()
          },
          (error) => this.globalService.handleError(error)
        )
      } else {
        this.globalService.handleErrorMessage(`Quantidade inválida`)
      } 
    }
    return false
  }

}
