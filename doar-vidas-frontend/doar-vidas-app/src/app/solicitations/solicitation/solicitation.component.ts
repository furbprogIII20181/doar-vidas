import { Component, OnInit } from "@angular/core";
import { GlobalService } from "../../services/global.service";
import { Router, ActivatedRoute } from "@angular/router";
import { Solicitation } from "../../model/solicitation.model";
import { SolicitationsService } from "../../services/solicitations.service";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";

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

  getSolicitation(): void {
    const solicitationId = this.route.snapshot.params.id;

    this.solicitationsService
      .getSolicitation(solicitationId)
      .subscribe(response => {
        this.solicitation = response;
        },
        error => this.globalService.handleError(error)
      );
  }

  getMappedBlood(bloodType: string): string {
    return this.solicitationsService.convertBloodType(bloodType)
  }

  getDonatorId(): string {
    return JSON.parse(localStorage.getItem("user_info")).id;
  }
}
