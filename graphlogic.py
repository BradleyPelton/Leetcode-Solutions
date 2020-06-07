from matplotlib import pyplot as plt
import matplotlib.dates as mdates
import datetime


results = [
    ['06/06', 64.367],
    ['05/30', 64.526],
    ['05/30', 41.521],
    ['05/23', 55.109],
    ['05/16', 67.190],
    ['05/16', 42.322],
    ['05/09', 45.301],
    ['05/02', 59.783],
    ['05/02', 36.147],
    ['04/25', 55.634],
    ['04/18', 79.905],
    ['04/18', 32.082],
    ['04/11', 78.335],
    ['04/04', 61.380],
    ['04/04', 45.532],
    ['03/28', 76.434],
    ['03/21', 68.548],
    ['03/21', 32.919],
    ['03/14', 47.413],
    ['03/07', 48.908],
    ['03/07', 56.330],
    ['02/29', 51.688],
    ['02/22', 58.655],
    ['02/22', 32.819],
    ['02/15', 59.215],
    ['02/08', 33.405],
    ['02/08', 33.929],
    ['02/01', 40.488]
]

dates = [result[0] for result in results]
dates_formated = [datetime.datetime.strptime(date + '/2020', "%m/%d/%Y").date() for date in dates]

percentiles = [result[1] for result in results]

plt.plot(dates_formated, percentiles)
plt.xlabel('competition date')
plt.ylabel('Competition Rank(Percentile)')
plt.legend(['Competition Rank(Percentile)'])
plt.axhline(y=50, color='r', linestyle='-')
axes = plt.gca()
# axes.set_xlim([xmin,xmax])
axes.xaxis.set_major_locator(mdates.DayLocator(interval=21))
axes.xaxis.set_tick_params(rotation=320)  # Rotate the x axis markers
axes.set_ylim([0, 100])
plt.show()
