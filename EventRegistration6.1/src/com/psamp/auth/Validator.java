package com.psamp.auth;

class Validator {

	boolean matchTwoStrings(String one, String two) {
		boolean rtn;

		synchronized (this) {
			rtn = one.equals(two);
		}

		return rtn;
	}

	boolean checkThatStringIsOfProperLength(String str, int properLength) {
		boolean rtn;

		synchronized (this) {
			rtn = str.length() >= properLength;
		}

		return rtn;
	}

}
