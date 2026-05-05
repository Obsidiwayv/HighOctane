package wayvlyte.space.octane.Entities;

/**
 * An internal event interface - useful for thing such as moderation logging
 */
public interface IInternalEventResponder {
    /**
     * Serves as a way to execute the event
     * @param <T> The object or string that will be broadcasted to the event
     */
    <T>void Execute(T EventMessage);
}
