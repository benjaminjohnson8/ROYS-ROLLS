package raysrentals.co.uk.lib.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Not implemented
 * 
 */
@MappedSuperclass
public abstract class VersionControlled extends ModelBase
{
	private static final long serialVersionUID = -417237906345149484L;
	
	@Version
	@Column(name="version_number", nullable=false)
	//http://docs.jboss.org/hibernate/orm/4.0/devguide/en-US/html/ch05.html
	private Integer versionNumber;
	

	public Integer getVersionNumber()
	{
		return versionNumber;
	}

	public void setVersionNumber(Integer versionNumber)
	{
		this.versionNumber = versionNumber;
	}
}
