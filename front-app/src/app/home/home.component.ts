import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../_service';
import { Usuario } from '../_models';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {

  usuarios: Usuario[] = [];

  constructor(private usuariosService:UsuariosService) { }

  ngOnInit(): void {
    this.carregarTodosUsuarios();
  }

  deletarUsuario(id: number) {
    this.usuariosService.delete(id).pipe().subscribe(() => {
      this.carregarTodosUsuarios()
    }, error => {
      console.log("Ocorreu um erro ao tentar excluir o usuário, " + error);
    });
  }

  private carregarTodosUsuarios() {
      this.usuariosService.getAll().subscribe(usuarios => {
        this.usuarios = usuarios;
      }, error => {
        console.log("Ocorreu um erro ao tentar listar usuários, " + error);
      });
  }

}
