package com.wselwood.mpcreader;

import java.util.Date;

/**
 * Immutable class holding all the information about a minor planet decoded out of a file.
 *
 * These should not be constructed outside of the MinorPlanetReader.
 *
 * Created by wselwood on 14/04/14.
 */
public class MinorPlanet {

    private final String number;
    private final Double absoluteMagnitude;
    private final Double slope;
    private final Date epoch;
    private final double meanAnomalyEpoch;
    private final double argumentOfPerihelion;
    private final double longitudeOfTheAscendingNode;
    private final double inclinationToTheEcliptic;
    private final double orbitalEccentricity;
    private final double meanDailyMotion;
    private final double semimajorAxis;
    private final String uncertaintyParameter;
    private final String reference;
    private final Integer numberOfObservations;
    private final Integer numberOfOppositions;
    private final Double rMSResidual;
    private final String coarseIndicatorOfPerturbers;
    private final String preciseIndicatorOfPerturbers;
    private final String computerName;
    private final int hexDigitFlags;
    private final String readableDesignation;
    private final Date   dateOfLastObservation;

    private final int    yearOfFirstObservation;
    private final int    yearOfLastObservation;

    private final int    arcLength;

    /**
     * You do not want to use this. These should only be constructed from the readers.
     */
    public MinorPlanet(String number, Double absoluteMagnitude, Double slope, Date epoch, double meanAnomalyEpoch,
                       double argumentOfPerihelion, double longitudeOfTheAscendingNode, double inclinationToTheEcliptic,
                       double orbitalEccentricity, double meanDailyMotion, double semimajorAxis,
                       String uncertaintyParameter, String reference, Integer numberOfObservations, Integer numberOfOppositions,
                       int yearOfFirstObservation, int yearOfLastObservation, int arcLength, Double rMSResidual, String coarseIndicatorOfPerturbers,
                       String preciseIndicatorOfPerturbers, String computerName, int hexDigitFlags,
                       String readableDesignation, Date dateOfLastObservation) {
        this.number = number;
        this.absoluteMagnitude = absoluteMagnitude;
        this.slope = slope;
        this.epoch = epoch;
        this.meanAnomalyEpoch = meanAnomalyEpoch;
        this.argumentOfPerihelion = argumentOfPerihelion;
        this.longitudeOfTheAscendingNode = longitudeOfTheAscendingNode;
        this.inclinationToTheEcliptic = inclinationToTheEcliptic;
        this.orbitalEccentricity = orbitalEccentricity;
        this.meanDailyMotion = meanDailyMotion;
        this.semimajorAxis = semimajorAxis;
        this.uncertaintyParameter = uncertaintyParameter;
        this.reference = reference;
        this.numberOfObservations = numberOfObservations;
        this.numberOfOppositions = numberOfOppositions;
        this.rMSResidual = rMSResidual;
        this.coarseIndicatorOfPerturbers = coarseIndicatorOfPerturbers;
        this.preciseIndicatorOfPerturbers = preciseIndicatorOfPerturbers;
        this.computerName = computerName;
        this.hexDigitFlags = hexDigitFlags;
        this.readableDesignation = readableDesignation;
        this.dateOfLastObservation = dateOfLastObservation;

        this.yearOfFirstObservation = yearOfFirstObservation;
        this.yearOfLastObservation  = yearOfLastObservation;

        this.arcLength = arcLength;

    }

    public String getNumber() {
        return number;
    }

    public Double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    public Double getSlope() {
        return slope;
    }

    public Date getEpoch() {
        return epoch;
    }

    public double getMeanAnomalyEpoch() {
        return meanAnomalyEpoch;
    }

    public double getArgumentOfPerihelion() {
        return argumentOfPerihelion;
    }

    public double getLongitudeOfTheAscendingNode() {
        return longitudeOfTheAscendingNode;
    }

    public double getInclinationToTheEcliptic() {
        return inclinationToTheEcliptic;
    }

    public double getOrbitalEccentricity() {
        return orbitalEccentricity;
    }

    public double getMeanDailyMotion() {
        return meanDailyMotion;
    }

    public double getSemimajorAxis() {
        return semimajorAxis;
    }

    public String getUncertaintyParameter() {
        return uncertaintyParameter;
    }

    public String getReference() {
        return reference;
    }

    public Integer getNumberOfObservations() {
        return numberOfObservations;
    }

    public Integer getNumberOfOppositions() {
        return numberOfOppositions;
    }

    public Double getrMSResidual() {
        return rMSResidual;
    }

    public String getCoarseIndicatorOfPerturbers() {
        return coarseIndicatorOfPerturbers;
    }

    public String getPreciseIndicatorOfPerturbers() {
        return preciseIndicatorOfPerturbers;
    }

    public String getComputerName() {
        return computerName;
    }

    public int getHexDigitFlags() {
        return hexDigitFlags;
    }

    public String getReadableDesignation() {
        return readableDesignation;
    }

    public Date getDateOfLastObservation() {
        return dateOfLastObservation;
    }

    public int getYearOfFirstObservation() {
        return yearOfFirstObservation;
    }

    public int getYearOfLastObservation() {
        return yearOfLastObservation;
    }

    public int getArcLength() {
        return arcLength;
    }

    /**
     * Get the orbit type of this minor planet if one was supplied.
     * @return the Orbit type if one was supplied Null otherwise.
     */
    public OrbitType getOrbitType() {
        return OrbitType.lookUp.get(hexDigitFlags & 0x3F); // 00111111
    }

    public boolean isNearEarthObject() {
        return (hexDigitFlags & 2048) != 0;
    }

    public boolean isLargeNearEarthObject() {
        return (hexDigitFlags & 4096) != 0;
    }

    public boolean isOneOppositionObjectSeenAtEarlierOpposition() {
        return (hexDigitFlags & 8192) != 0;
    }

    public boolean isCriticalListNumberedObject() {
        return (hexDigitFlags & 16384) != 0;
    }

    public boolean isPotentiallyHazardousAsteroid() {
        return (hexDigitFlags & 32768) != 0;
    }


}
