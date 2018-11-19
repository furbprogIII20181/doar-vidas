import { BloodType } from "./blood.type.model";

export interface MyUser {
    id: number,
    name: string,
    lastName: string,
    email: string,
    city: string,
    state: string,
    phone: string,
    description: string,
    cpfCnpj: number,
    bloodType: BloodType;
}