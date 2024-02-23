package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="HOST")
public class Host {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="HOST_NAME")
	private String hostName;

	public Host() {
		super();
	}
	
	public Host(int id, String hostName) {
		super();
		this.id = id;
		this.hostName = hostName;
	}
	
	public Host(String hostName) {
		super();
		this.hostName = hostName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", hostName=" + hostName + "]";
	}
	
}
