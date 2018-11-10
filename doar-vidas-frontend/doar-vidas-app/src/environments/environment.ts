// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  api: {
    states: "http://www.mocky.io/v2/5ba64a653200006600963d74",
    // states: "http://www.mocky.io/v2/5ba64cb33200005600963d75",
    registerDonator: "http://localhost:8080/rest/public/donator/save",
    registerInstitution: "http://localhost:8080/rest/public/institution/save",
    login: "http://localhost:8080/oauth/token",
    getUserInfo: "http://localhost:8080/rest/private/user/findByEmail",
    donatorsListAll: "http://localhost:8080/rest/public/donator/listAll",
    solicitationsListAll: "http://localhost:8080/rest/private/solicitation/listAll",
    solicitationById: "http://localhost:8080/rest/private/solicitation",
    solicitationByInstitutionId: "http://localhost:8080/rest/private/solicitation/findByInstitution"
  }
};

/*
 * In development mode, for easier debugging, you can ignore zone related error
 * stack frames such as `zone.run`/`zoneDelegate.invokeTask` by importing the
 * below file. Don't forget to comment it out in production mode
 * because it will have a performance impact when errors are thrown
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
