import { Component } from "@angular/core";

@Component({
  selector: 'app-error-500',
  template: `
    <error-code
      code="500"
      title="Le serveur rencontre quelques difficultés!"
      message="Désolé... vous ne pouvez pas accéder à cette resource pour l'instant. Merci de réessayer plus tard."
    >
    </error-code>
  `,
})
export class InternalServerErrorComponent {}

