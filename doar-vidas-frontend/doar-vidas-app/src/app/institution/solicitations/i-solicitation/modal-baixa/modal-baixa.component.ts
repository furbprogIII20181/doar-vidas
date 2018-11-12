import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-modal-baixa',
  templateUrl: './modal-baixa.component.html',
  styleUrls: ['./modal-baixa.component.css']
})
export class ModalBaixaComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<ModalBaixaComponent>,@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
