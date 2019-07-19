export interface Usuario {
    id: number;
    nome: string;
    email: string;
    senha: string;
    status: string;
    cadastroData: Date;
    tipoUsuario: string;
}
