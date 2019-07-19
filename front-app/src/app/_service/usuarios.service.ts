import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Usuario } from '../_models';

@Injectable({ providedIn: 'root' })
export class UsuariosService {
    
    apiUrl = "https://api.github.com/";

    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Usuario[]>(this.apiUrl+`/usuarios`);
    }

    getById(id: number) {
        return this.http.get(this.apiUrl + `/usuarios/` + id);
    }

    register(usuario: Usuario) {
        return this.http.post(this.apiUrl + `/usuarios`, usuario);
    }

    update(usuario: Usuario) {
        return this.http.put(this.apiUrl + `/usuarios` + usuario.id, usuario);
    }

    delete(id: number) {
        return this.http.delete(this.apiUrl + `/usuarios/` + id);
    }
}