package com.demo.project62.statemachine;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        UberTrip state = UberTrip.TRIP_REQUESTED;
        state = state.nextState("SUCCESS");
        assertEquals(UberTrip.PAYMENT, state);
        //Failed Payment
        state = state.nextState("FAIL");
        assertEquals(UberTrip.TRIP_REQUESTED, state);
        state = state.nextState("SUCCESS");
        assertEquals(UberTrip.PAYMENT, state);
        state = state.nextState("SUCCESS");
        //Success payment
        assertEquals(UberTrip.DRIVER_ASSIGNED, state);

        state = state.nextState("SUCCESS");
        assertEquals(UberTrip.TRIP_END, state);
    }
}

enum UberTrip {

    TRIP_REQUESTED {
        @Override
        public UberTrip nextState(String action) {
            if(action.equals("SUCCESS")) {
                return PAYMENT;
            }
            throw new UnsupportedOperationException("Not Supported!");
        }
    },
    PAYMENT {
        @Override
        public UberTrip nextState(String action) {
            if(action.equals("SUCCESS")) {
                return DRIVER_ASSIGNED;
            } else if(action.equals("FAIL")) {
                return TRIP_REQUESTED;
            } else {
                throw new UnsupportedOperationException("Not Supported!");
            }
        }
    },
    DRIVER_ASSIGNED {
        @Override
        public UberTrip nextState(String action) {
            if(action.equals("SUCCESS")) {
                return TRIP_END;
            }
            throw new UnsupportedOperationException("Not Supported!");
        }
    },
    TRIP_END {
        @Override
        public UberTrip nextState(String action) {
            throw new UnsupportedOperationException("Not Supported!");
        }
    };

    public abstract UberTrip nextState(String action);

}