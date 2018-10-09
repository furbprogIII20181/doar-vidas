export interface Solicitation {
    id: number,
    institution: {
        id: number,
        name: string,
        lastName: string,
        city: string,
        state: string,
        phone: string,
        user: {
            id: number,
            email: string,
            password: string,
            roles: [
                {
                    id: number,
                    name: string
                }
            ]
        },
        description: string,
        cnpj: number
    },
    bloodType: string,
    quantity: number
}