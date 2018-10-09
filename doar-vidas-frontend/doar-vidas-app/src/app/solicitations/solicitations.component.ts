import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Solicitation } from '../model/solicitation.model';

@Component({
  selector: 'app-solicitations',
  templateUrl: './solicitations.component.html',
  styleUrls: ['./solicitations.component.css']
})
export class SolicitationsComponent implements OnInit {

  exampleData = [
      {
          "id": 12,
          "institution": {
              "id": 8,
              "name": "Hemosc",
              "lastName": "Blumenau",
              "city": "Blumenau",
              "state": "SC",
              "phone": "123123",
              "user": {
                  "id": 6,
                  "email": "hemosc@hotmail.com",
                  "password": "$2a$10$5p.Gkl5raFiM/vx7gJMJm.qzBXrCwqrzS3HsitCEwzlBDwJJYONI6",
                  "roles": [
                      {
                          "id": 7,
                          "name": "USER"
                      }
                  ]
              },
              "description": "aaa",
              "cnpj": 123456789
          },
          "bloodType": "ONEG",
          "quantity": 2.5
      }
  ];

  solicitationsTable = new MatTableDataSource(this.exampleData);

  constructor() { }

  ngOnInit() {
  }

  displayedColumns: string[] = ['id', 'institution.name', 'institution.city', 'institution.state', 'bloodType']

  applyFilter(filterValue: string) {
    this.solicitationsTable.filter = filterValue.trim().toLowerCase();
  }

}
