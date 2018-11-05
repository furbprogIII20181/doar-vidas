import { Component, OnInit } from "@angular/core";
import { GlobalService } from "../../services/global.service";
import { Router, ActivatedRoute } from "@angular/router";
import { Solicitation } from "../../model/solicitation.model";
import { SolicitationsService } from "../../services/solicitations.service";

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
    private solicitationsService: SolicitationsService
  ) {}

  ngOnInit() {
    if (!this.globalService.getIsLoggedin()) {
      this.router.navigate(["/login"]);
    }
    this.getSolicitation();
  }

  getSolicitation(): void {
    const solicitationId = this.route.snapshot.params.id;

    this.solicitationsService
      .getSolicitation(solicitationId)
      .subscribe(
        data => console.log(data),
        error => this.globalService.handleError(error)
      );
  }
}
