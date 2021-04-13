package utility;

public final class Pair <X, Y> {
	
	private X x;
	private Y y;
	
	public Pair(final X x, final Y y) {
		
		super();
		this.x = x;
		this.y = y;
	}
	
	public X getX() {
		return x; 
	}
	
	public Y geyY() {
		return y;
	}
	
	public void setX(final X x) {
		this.x = x;
	}
	
	public void setY(final Y y) {
		this.y = y;
	}
	 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	
	}
	@Override
	public boolean equals(final Object object) {
		if (this == object) {
			return true;
		}
		
		if (object == null) {
			return false;
		}
		
		if (getClass() != object.getClass()) {
			return false;
		}
		
		final Pair other = (Pair)object;
		if (x == null) {
			if(other.x != null) {
				return false;
			}
		}
			else if (!x.equals(other.x)) {
				return false;
			}
			if (y == null) {
				if (other.y != null) {
					return false;
				}
			}
				else if (!y.equals(other.y)) {
					return false;
				
			}
				return true;
			}
	@Override
	public String toString() {
		return "Pair[x="+ x +", y=" + y + "]";

	} 
	}
	
	

