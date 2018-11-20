import { Component, OnInit } from "@angular/core";
import { MatTableDataSource, MatDialog } from "@angular/material";
import { Solicitation } from "../../../model/solicitation.model";
import { GlobalService } from "../../../services/global.service";
import { Router } from "@angular/router";
import { SolicitationsService } from "../../../services/solicitations.service";
import { ModalBaixaComponent } from "./modal-baixa/modal-baixa.component";
import { Baixa } from "../../../model/baixa.model";

@Component({
  selector: 'app-i-solicitation',
  templateUrl: './i-solicitation.component.html',
  styleUrls: ['./i-solicitation.component.css']
})
export class ISolicitationComponent implements OnInit {

  solicitationsArray: Array<Solicitation>

  solicitationsTable;

  constructor(
    private globalService: GlobalService,
    private router: Router,
    private solicitationsService: SolicitationsService,
    public dialog: MatDialog
  ) {}

  quantiy: number = 0

  ngOnInit() {
    if (!this.globalService.getIsLoggedin()) {
      this.router.navigate(['/login']);
    }
    this.getAllSolicitations();

    if (!!this.solicitationsTable) {
      this.solicitationsTable.filterPredicate = (data: any, filter: string) => {
        var str = this.getStringObject(data);
        return str
          .toLowerCase()
          .trim()
          .includes(filter.toLowerCase().trim());
      };
    }
  }

  openDialog(element: any): void {
    const dialogRef = this.dialog.open(ModalBaixaComponent, {
      width: '250px',
      data: {quantity: this.quantiy}
    });

    dialogRef.afterClosed().subscribe(result => {
      
      if (typeof result == 'undefined') return

      let qty = parseFloat(result)

      if (!isNaN(qty) && qty > 0 && qty <= element.quantity) {
        this.darBaixa(element, qty);
      } else {
        this.globalService.handleErrorMessage(`Quantidade inválida`)
        this.openDialog(element)
      }
    });
  }

  darBaixa(element, quantity:number): any {
    let params: Baixa = {
      id: element.id,
      quantity: quantity
    }
    return this.solicitationsService.darBaixa(params).subscribe(
      (data) => {
        this.getAllSolicitations()
        this.globalService.handleSuccess(`Quantidade de sangue da Solicitação ${data.id} foi atualizada.`)
      },
      (error) => {
        console.log(error)
        this.openDialog(element)
        this.globalService.handleError(error)
      }
    )
  }

  deleteSolicitation(id: number): void {
    if(confirm(`Você realmente deseja excluir a solicitação ${id}?`)) {
      this.solicitationsService.deleteSolicitation(id).subscribe(
        (data) => {
          this.getAllSolicitations()
          this.globalService.handleSuccess(`Solicitação foi excluída.`)
        },
        (error) => this.globalService.handleError(error)
      )
    }
  }

  getAllSolicitations(): void {
    let institutionId = JSON.parse(localStorage.getItem('user_info')).id
    this.solicitationsService.getAllSolicitationsByInstitutionID(institutionId).subscribe(response => {
      this.solicitationsArray = response;
      this.solicitationsTable = new MatTableDataSource(this.solicitationsArray);
    },
    (error) => this.globalService.handleError(error))
  }

  getStringObject(data) {
    let str = "";
    Object.keys(data).forEach(e => {
      if (typeof data[e] === "object") {
        str += this.getStringObject(data[e]);
      } else {
        str += data[e];
      }
    });
    return str;
  }

  displayedColumns: string[] = [
    "id",
    "institution.city",
    "institution.state",
    "bloodType",
    "quantity",
    "actions"
  ];

  applyFilter(filterValue: string) {
    this.solicitationsTable.filter = filterValue.trim().toLowerCase();
  }

}
