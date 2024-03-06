package com.kh.Test240207_2;

import java.util.Objects;

public class Farm {
	private String kind;

	public Farm() {
		super();
	}

	public Farm(String kind) {
		super();
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return kind + " : ";
	}

	@Override
	public int hashCode() {
		return Objects.hash(kind);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Farm other = (Farm) obj;
		return Objects.equals(kind, other.kind);
	}
}
