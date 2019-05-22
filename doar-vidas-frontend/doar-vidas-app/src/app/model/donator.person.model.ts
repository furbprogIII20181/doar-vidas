export interface DonatorPerson {
    id: number,
    name: string,
    city: string,
    state: string,
    phone: string,
    user: {
        id: number,
        email: string,
        password: string,
        roles: {
            id: number,
            name: string
        }
    },
    description: string,
    cpfCnpj: number,
    bloodType: string,
    discriminatorValue: string
}