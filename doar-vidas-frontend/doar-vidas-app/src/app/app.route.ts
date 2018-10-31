import {Routes} from "@angular/router";
import {HomeComponent} from "../app/home/home.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { SolicitationsComponent } from "./solicitations/solicitations.component";
import { SolicitationComponent } from "./solicitations/solicitation/solicitation.component";
import { DonatorsComponent } from "./donators/donators.component";
import { DonationComponent } from "./donation/donation.component";

export const ROUTES: Routes = [
    {path: '', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'solicitations', component: SolicitationsComponent},
    {path: 'solicitations/:id', component: SolicitationComponent},
    {path: 'donators', component: DonatorsComponent},
    {path: 'donation', component: DonationComponent}
]