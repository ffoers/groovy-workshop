package exercises.three

import exercises.one.Datapoint

/**
 * Your task: refactor to Groovy
 */
class JavaLike2 {
    private List<Datapoint> datapoints = new ArrayList<>()

    public void add(Datapoint datapoint) {
        datapoints.add(datapoint)
    }
    /**
     * This method finds all datapoints whose x-component is higher than x1 and lower than x2
     * @param x1 lower boundary
     * @param x2 upper boundary
     * @return a collection of all datapoints between x1 and x2
     */
    List<Datapoint> allBetween(BigInteger x1, BigInteger x2) {
        List<Datapoint> resultList = new ArrayList<>()
        for (Datapoint datapoint : datapoints) {
            if (datapoint.getX() > x1 && datapoint.getX() < x2) {
                resultList.add(datapoint)
            }
        }
        return resultList;
    }

    /**
     * Checks, if all datapoints' y values are higher than specified
     * @param threshold for the y value
     * @return true if all y values are higher than threshold
     */
    Boolean areAllGreaterThan(BigInteger lowerThreshold) {
        for (Datapoint datapoint : datapoints) {
            if (datapoint.getY() <= lowerThreshold) {
                return false;
            }
        }
        return true;
    }

    /**
     * Build sum of all y values
     * @return the sum of all y values
     */
    public BigInteger sum() {
        BigInteger result = 0
        for (Datapoint datapoint : datapoints) {
            result += datapoint.getY()
        }
        return result
    }


    public void flipXandY() {
        List<Datapoint> result = new ArrayList<>()
        for (Datapoint datapoint : datapoints) {
            result.add(new Datapoint(datapoint.getY(), datapoint.getX()))
        }
        datapoints = result
    }

    //TODO refactor this to a recursive solution

/**
 * Splits all datapoints into their x and y components
 * @return a Map containing two collections with keys x and y, one containing all x values and one containing all y values
 */
    public Map<String, Collection<BigInteger>> split() {
        Map<String, Collection<BigInteger>> result = new HashMap<>()
        result.put("x", new ArrayList<BigInteger>())
        result.put("y", new ArrayList<BigInteger>())

        for (Datapoint datapoint : datapoints) {
            result.get("x").add(datapoint.getX());
            result.get("y").add(datapoint.getY());
        }

        return result;
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        JavaLike2 javaLike2 = (JavaLike2) o

        if (datapoints != javaLike2.datapoints) return false

        return true
    }

    int hashCode() {
        return (datapoints != null ? datapoints.hashCode() : 0)
    }
}
