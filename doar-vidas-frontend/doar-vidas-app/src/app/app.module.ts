import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ROUTES } from './app.route';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule, MatCheckboxModule, MatIconModule, MatMenuModule, MatCardModule, MatToolbarModule, MatSidenavModule, MatSelectModule, MatPaginatorModule, MatTableModule, MatSortModule, MatFormFieldModule, MatRadioModule, MatInputModule, MatDividerModule, MatDatepickerModule, MatNativeDateModule, DateAdapter } from '@angular/material';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginService } from './services/login.service';
import { HttpClientModule } from "@angular/common/http";
import { RegisterComponent } from './register/register.component';
import { StatesService } from './services/states.service';
import { SolicitationsComponent } from './solicitations/solicitations.component';
import { SolicitationComponent } from './solicitations/solicitation/solicitation.component';
import { DonatorsComponent } from './donators/donators.component';
import { ContactComponent } from './contact/contact.component';
import { SuccessComponent } from './solicitations/solicitation/success/success.component';
import { ISolicitationComponent } from './institution/solicitations/i-solicitation/i-solicitation.component';
import { DateFormat } from './date-format';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MenuComponent,
    LoginComponent,
    RegisterComponent,
    SolicitationsComponent,
    SolicitationComponent,
    DonatorsComponent,
    ContactComponent,
    SuccessComponent,
    ISolicitationComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatMenuModule,
    MatCardModule,
    MatToolbarModule,
    MatSidenavModule,
    MatFormFieldModule,
    MatInputModule,
    MatDividerModule,
    MatRadioModule,
    MatSelectModule,
    MatTableModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatSortModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [LoginService, StatesService, {provide: DateAdapter, useClass: DateFormat}],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(private dateAdapter:DateAdapter<Date>) {
		dateAdapter.setLocale('pt-br'); // DD/MM/YYYY
	}
 }
