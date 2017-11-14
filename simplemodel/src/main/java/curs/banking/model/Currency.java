package curs.banking.model;

public enum Currency {
  RON(1L), EUR(2L), USD(3L), GBP(4L);

  private long mId;
  
  private Currency(long pId) {
    mId = pId;
  }

  public long getId() {
    return mId;
  }
  
  public static Currency getById(long pId) {
	  for(Currency c : values()) {
		  if(c.getId() == pId) {
			  return c;
		  }
	  }
	  return null;
  }
   
}
