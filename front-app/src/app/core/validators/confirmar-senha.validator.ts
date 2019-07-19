import { AbstractControl } from '@angular/forms';

export class ConfirmarSenhaValidator {
  static MatchPassword(control: AbstractControl) {
    let senha = control.get('senha').value;
    let confirmarSenha = control.get('confirmarSenha').value;
    return senha === confirmarSenha ? null : control.get('confirmarSenha').setErrors({ ConfirmarSenha: true });
  }
}
