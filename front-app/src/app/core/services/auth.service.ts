import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../models';
import { Observable, of, BehaviorSubject, EMPTY } from 'rxjs';
import { catchError, map, take } from 'rxjs/operators';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private currentUserSubject$: BehaviorSubject<Usuario>;

  constructor(
    private http: HttpClient,
  ) {
    this.currentUserSubject$ = new BehaviorSubject<Usuario>(JSON.parse(localStorage.getItem(environment['USER'])));
  }

  public get currentUsuario(): Usuario {
    const user: Usuario = JSON.parse(localStorage.getItem(environment['USER']));
    return user;
  }

  public get isUserAuthenticated() {
    return this.currentUserSubject$.value == null ? false : true;
  }

  public get currentUserSubject() {
    return this.currentUserSubject$.asObservable().pipe(take(1));
  }

  public login(email: string, senha: string): Observable<Usuario> {
    return this.http.post<any>(`${environment['URL_BASE']}/usuario-service/usuarios/login`, { email: email, senha: senha })
      .pipe(
        take(1),
        map(success => {
          if (success.data) {
            localStorage.setItem(environment['USER'], JSON.stringify(success.data));
            this.currentUserSubject$.next(success.data);
            return success.data;
          } else {
            throw new Error(success.message);
          }
        }),
        catchError(this.handleError<any>('login-user', null))
      )
  }

  public logout() {
    localStorage.removeItem(environment['USER']);
    this.currentUserSubject$.next(null);
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error.error.message);
      return EMPTY;
    };
  }

}
