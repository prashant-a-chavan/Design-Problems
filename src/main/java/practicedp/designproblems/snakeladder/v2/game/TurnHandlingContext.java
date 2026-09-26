package practicedp.designproblems.snakeladder.v2.game;

import practicedp.designproblems.snakeladder.v2.rules.TurnContext;

/**
 * Context passed to outcome handlers.
 * Delegates to TurnContext for turn state; holds Game and resolved nextPosition.
 *
 * @param nextPosition resolved position (after bounce-back, if applicable)
 */
public record TurnHandlingContext(Game game, TurnContext turnContext, int nextPosition) {
}


