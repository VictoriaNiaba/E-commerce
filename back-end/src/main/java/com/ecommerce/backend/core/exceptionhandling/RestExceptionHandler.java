package com.ecommerce.backend.core.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.backend.core.exceptionhandling.exceptions.EntityNotFoundException;

/**
 * <p>
 * Classe chargée de la gestion centralisée des exceptions renvoyées par l'API.
 * </p>
 * <p>
 * Chaque méthode définit un gestionnaire d'exceptions. Leur rôle est de prendre
 * en charge la réponse au client en cas d'imprévu. Les réponses sont toutes au
 * format {@link RestApiError}.
 * </p>
 * 
 * @author Nicolas DESNOUST
 *
 */
@ControllerAdvice
public class RestExceptionHandler {

	private @Autowired Environment env;

	/**
	 * Construit une réponse générique avec un statut "500" pour les erreurs / bugs
	 * n'ayant pas de gestionnaire dédié.
	 * 
	 * @param e       l'exception à gérer.
	 * @param request un objet fournissant des informations sur la requête.
	 * @return Une réponse destinée au client de l'API.
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<RestApiError> handleAllExceptions(Exception e, HttpServletRequest request) {

		String title = env.getProperty("responses.internal-server-error.title");
		String detail = env.getProperty("responses.internal-server-error.detail");
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		String path = request.getRequestURI();

		RestApiError apiError = new RestApiError(status, title, detail, path);

		return ResponseEntity.status(status).body(apiError);
	}

	/**
	 * Construit une réponse pour les erreurs concernant la demande d'une entité via
	 * un identifiant incorrect.
	 * 
	 * @param e       l'exception à gérer.
	 * @param request un objet fournissant des informations sur la requête.
	 * @return Une réponse destinée au client de l'API.
	 */
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<RestApiError> handleEntityNotFoundException(EntityNotFoundException e,
			HttpServletRequest request) {

		String title = env.getProperty("responses.entity-not-found.title");
		String detail = e.getMessage();
		HttpStatus status = HttpStatus.NOT_FOUND;
		String path = request.getRequestURI();

		RestApiError apiError = new RestApiError(status, title, detail, path);

		return ResponseEntity.status(status).body(apiError);
	}
}
