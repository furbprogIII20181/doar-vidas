import { Routes } from "@angular/router";
import { HomeComponent } from "../app/home/home.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { SolicitationsComponent } from "./solicitations/solicitations.component";
import { SolicitationComponent } from "./solicitations/solicitation/solicitation.component";
import { DonatorsComponent } from "./donators/donators.component";
import { ContactComponent } from "./contact/contact.component";
import { SuccessComponent } from "./solicitations/solicitation/success/success.component";
import { ISolicitationComponent } from "./institution/solicitations/i-solicitation/i-solicitation.component";
import { NewSolicitationComponent } from "./institution/solicitations/new-solicitation/new-solicitation.component";
import { UserComponent } from "./user/user.component";
import { UserEditComponent } from "./user/user-edit/user-edit.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import {DonationsComponent} from "./donations/donations.component";

export const ROUTES: Routes = [
  { path: "", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "solicitations", component: SolicitationsComponent },
  { path: "solicitations/success", component: SuccessComponent },
  { path: "solicitations/:id", component: SolicitationComponent },
  { path: "donators", component: DonatorsComponent },
  { path: "donators/:id", component: ContactComponent },
  { path: "institution/solicitations", component: ISolicitationComponent },
  { path: "institution/solicitations/new", component: NewSolicitationComponent },
  { path: "user", component: UserComponent },
  { path: "user/edit", component: UserEditComponent },
  { path: "user/donations", component: DonationsComponent },
  { path: "**", component: NotFoundComponent }
];
