from collections import defaultdict
# accepted first try
class UndergroundSystem:

    def __init__(self):
        self.trips = defaultdict(list)

        # {ID: [start_location, end_location,checkin, checkout]}
        #[ID, START_LOCATION, END_LOCATION, CHECKIN, CHECKOUT]

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.trips[id].append([stationName, "UNKKNOWN_L", t, "UNKNOWN_T"])

    def checkOut(self, id: int, stationName: str, t: int) -> None:
        if self.trips[id][-1][-1] == "UNKNOWN_T":
            self.trips[id][-1][-1] = t
            self.trips[id][-1][-3] = stationName

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        number_of_trips = 0
        duration_of_all_trips = 0
        for paths in self.trips.values():
            for trip in paths:
                if trip[0] == startStation and trip[1] == endStation:
                    number_of_trips += 1
                    duration_of_all_trips += trip[3] - trip[2]
        avg_trip = duration_of_all_trips/number_of_trips
        # print(avg_trip)
        return(avg_trip)

# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)


a = UndergroundSystem()
a.checkIn(45, "Leyton", 3)
a.checkIn(32, "Paradise", 8)
a.checkIn(27, "Leyton", 10)
a.checkOut(45, "Waterloo", 15)
a.checkOut(27, "Waterloo", 20)
a.checkOut(32, "Cambridge", 22)
a.getAverageTime("Paradise", "Cambridge")
a.getAverageTime("Leyton", "Waterloo")
a.checkIn(10, "Leyton", 24)
a.getAverageTime("Leyton", "Waterloo")
a.checkOut(10, "Waterloo", 38)
a.getAverageTime("Leyton", "Waterloo")