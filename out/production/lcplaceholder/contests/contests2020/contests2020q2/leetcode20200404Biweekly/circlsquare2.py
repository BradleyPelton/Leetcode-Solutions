# I didnt have time to learn the casadi library and to implement it
# I probably should have just manually done the optimization problem myself 
# instead of relying on a library. 
def closest_point_between_line_and_circle(x1, x2, y1, y2, x_center, y_center, radius):
    """ THIS IS AN OPTIMIZATION PROBLEM THROUGH AND THROUGH"""
    """ FIND THE CLOSEST POINT BETWEEN A LINE AND A CIRCLE"""

    import casadi as ca
    opti = ca.Opti()

    # Line segment
    t = opti.variable()
    line_seg = opti.bounded(0, t, 1)
    p0 = (x1, y1)
    p1 = (x1, y2)
    x = (1 - t) * p0 + t * p1

    # Circle
    y = opti.variable(2)
    circ = y[0]**2 + y[1]**2 == 1

    # Optimization problem
    dist_squared = (x[0] - y[0])**2 + (x[1] - y[1])**2
    opti.minimize(dist_squared)
    opti.subject_to(line_seg)
    opti.subject_to(circ)

    # Solve
    opti.solver('ipopt')
    sol = opti.solve()

    # Result
    print(f"Distance = {sol.value(ca.sqrt(dist_squared))}")
    print(f"Point on line segment: {sol.value(x)}")
    print(f"Point on circle: {sol.value(y)}")