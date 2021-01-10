import { Component } from '@angular/core';

@Component({
  selector: 'not-found',
  template: `
    <error-code
      code="404"
      title="Page non-trouvée!"
      message="La resource que vous recherchez semble introuvable. Dirigez vous vers la page d'accueil en cliquant sur le bouton ci-dessous."
    ></error-code>
  `,
})
export class NotFoundComponent {}
