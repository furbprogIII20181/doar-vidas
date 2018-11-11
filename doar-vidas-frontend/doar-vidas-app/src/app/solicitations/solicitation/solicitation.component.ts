import { Component, OnInit } from "@angular/core";
import { GlobalService } from "../../services/global.service";
import { Router, ActivatedRoute } from "@angular/router";
import { Solicitation } from "../../model/solicitation.model";
import { SolicitationsService } from "../../services/solicitations.service";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import {Donation} from "../../model/donation.model";

@Component({
  selector: "app-solicitation",
  templateUrl: "./solicitation.component.html",
  styleUrls: ["./solicitation.component.css"]
})
export class SolicitationComponent implements OnInit {
  constructor(
    private globalService: GlobalService,
    private router: Router,
    private route: ActivatedRoute,
    private solicitationsService: SolicitationsService,
    private formBuilder: FormBuilder
  ) {}

  solicitationForm: FormGroup

  solicitation: Solicitation

  minDate = new Date(Date.now());

  ngOnInit() {
    if (!this.globalService.getIsLoggedin()) {
      this.router.navigate(["/login"]);
    }
    this.solicitationForm = this.formBuilder.group({
      donatorID: this.formBuilder.control('',[Validators.required]),
      institutionID: this.formBuilder.control('',[Validators.required]),
      date: this.formBuilder.control('', [Validators.required])
    })
    this.getSolicitation();
  }

  sundayFilter = (d: Date): boolean => {
    return d.getDay() !== 0
  }

  getSolicitation(): void {
    const solicitationId = this.route.snapshot.params.id;

    this.solicitationsService
      .getSolicitation(solicitationId)
      .subscribe(response => {
        this.solicitation = response;
        this.solicitationForm.get('donatorID').setValue(this.getDonatorId())
        this.solicitationForm.get('institutionID').setValue(this.solicitation.institutionId)
        },
        error => this.globalService.handleError(error)
      );
  }

  getMappedBlood(bloodType: string): string {
    return this.globalService.convertBloodType(bloodType)
  }

  getDonatorId(): string {
    return JSON.parse(localStorage.getItem("user_info")).id;
  }

  saveDonation(): any {
    let donation: Donation = this.solicitationForm.value
    this.solicitationsService
      .saveDonation(donation)
      .subscribe(
        (data) => this.solicitationsService.succesAction(data),
        (error) => this.globalService.handleError(error)
      )
  }

  onSubmit() {
    if (this.solicitationForm.valid) {
      this.saveDonation()
    }
  }
}
