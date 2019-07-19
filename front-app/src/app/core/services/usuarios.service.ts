import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Usuario } from '../models';
import { CrudService } from './crud.service';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService extends CrudService<Usuario, number> {

  constructor(
    protected http: HttpClient,
  ) {
    super(http, `${environment['URL_BASE']}/usuario-service/usuarios`);
  }

}
