import { Component, OnInit } from '@angular/core';
import { UsuariosService } from 'src/app/core/services';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/core/services/auth.service';
import { Router } from '@angular/router';
import { ConfirmarSenhaValidator } from 'src/app/core/validators/confirmar-senha.validator';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.sass']
})
export class RegisterComponent implements OnInit {

  private registerForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuariosService,
    private router: Router
  ) { }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.registerForm = this.fb.group({
      nome: [null, Validators.required],
      email: [null, Validators.compose([
        Validators.required,
        Validators.email,
      ])],
      senha: [null, Validators.compose([
        Validators.required,
        // Validators.minLength(6)
      ])],
      confirmarSenha: [null, Validators.compose([
        Validators.required,
      ])],
      status: [null],
      cadastroData: [null, Validators.compose([
        Validators.required,
      ])],
      tipoUsuario: [null, Validators.compose([
        Validators.required,
      ])],
    }, {
      validator: ConfirmarSenhaValidator.MatchPassword
    });
  }
}
