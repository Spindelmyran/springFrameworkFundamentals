package dataaccess;

import java.util.List;

import domain.Action;
import org.junit.Ignore;

// FOR USE IN A LATER CHAPTER - PLEASE IGNORE UNTIL THEN

@Ignore
public interface ActionDao 
{
	public void create(Action newAction);
	public List<Action> getIncompleteActions(String userId);
	public void update(Action actionToUpdate) throws RecordNotFoundException;
	public void delete(Action oldAction) throws RecordNotFoundException;
}
