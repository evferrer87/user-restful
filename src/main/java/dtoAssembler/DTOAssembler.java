package dtoAssembler;

public interface DTOAssembler<M> {
	
	public M convertToModel(Object obj);
	
}
