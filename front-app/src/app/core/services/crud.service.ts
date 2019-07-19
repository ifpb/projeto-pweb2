import { Observable, EMPTY } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CrudOperations } from '../interfaces/crud-operations.interface';
import { take, catchError } from 'rxjs/operators';

export abstract class CrudService<T, ID> implements CrudOperations<T, ID> {

  constructor(
    protected http: HttpClient,
    protected base: string
  ) { }

  public save(t: T): Observable<T> {
    return this.http.post<any>(this.base, t)
      .pipe(
        take(1),
        catchError(this.handleError())
      );
  }

  public update(id: ID, t: T): Observable<T> {
    return this.http.put<any>(`${this.base}/${id}`, t, {})
      .pipe(
        take(1),
        catchError(this.handleError())
      );
  }

  public findOne(id: ID): Observable<T> {
    return this.http.get<any>(`${this.base}/${id}`)
      .pipe(
        take(1),
        catchError(this.handleError())
      );
  }

  public findAll(): Observable<T[]> {
    return this.http.get<any>(this.base)
      .pipe(
        take(1),
        catchError(this.handleError())
      );
  }

  public delete(id: ID): Observable<T> {
    return this.http.delete<any>(`${this.base}/${id}`)
      .pipe(
        take(1),
        catchError(this.handleError())
      );
  }

  protected handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error.error.message);
      return EMPTY;
    };
  }
}
