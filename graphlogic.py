from matplotlib import pyplot as plt
import matplotlib.dates as mdates
import datetime


results = [
    ['08/29', 88.558],
    ['08/22', 67.407],
    ['08/22', 71.441],
    ['08/15', 58.828],
    ['08/08', 73.277],
    ['08/08', 68.269],
    ['08/01', 67.249],
    ['07/25', 51.554],
    # ['07/25', 26.368],  # Redacted, connection issues
    ['07/18', 70.512],
    ['07/11', 68.907],
    ['07/11', 61.688],
    ['07/04', 53.835],
    ['06/27', 89.589],
    ['06/27', 49.306],
    ['06/20', 52.984],
    ['06/13', 60.555],
    ['06/13', 50.134],
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
    ['02/01', 40.488],
]

dates = [result[0] for result in results]
dates_formated = [datetime.datetime.strptime(date + '/2020', "%m/%d/%Y").date() for date in dates]

percentiles = [result[1] for result in results]

plt.plot(dates_formated, percentiles)
plt.xlabel('competition date')
plt.ylabel('Competition Rank(Percentile)')
plt.legend(['Competition Rank(Percentile)'])
plt.gcf().subplots_adjust(bottom=0.15)
plt.axhline(y=50, color='r', linestyle='-')
axes = plt.gca()
# axes.set_xlim([xmin,xmax])
axes.xaxis.set_major_locator(mdates.DayLocator(interval=21))
axes.xaxis.set_tick_params(rotation=320)  # Rotate the x axis markers
axes.set_ylim([0, 100])
plt.show()
