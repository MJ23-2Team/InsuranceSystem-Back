package server.api.insurance.util;

import lombok.Getter;
import lombok.Setter;
import server.api.insurance.insurance.Insurance;
import server.api.insurance.util.Constants.Crud;
import server.api.insurance.util.Constants.Target;

@Getter
@Setter
public abstract class Team {
	private int teamID;
	private String teamName;
	public Insurance m_Insurance;

	public Team(){}

	public abstract void establishPolicy(Target target, Crud crud );
	public abstract void manage( Target target, Crud crud );
	public abstract void plan( Target target, Crud crud );
	public abstract void process( Target target, Crud crud );
}