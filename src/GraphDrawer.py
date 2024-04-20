import networkx as nx
import matplotlib.pyplot as plt

def draw_graph(array):
    n = len(array)
    G = nx.DiGraph()

    # Adding vertices
    for couple in array:
        G.add_node(couple[0])

    # Adding edges
    for i, couple in enumerate(array):
        vertex, num = couple
        left_index = (i - num) % n
        right_index = (i + num) % n
        G.add_edge(vertex, array[left_index][0])
        G.add_edge(vertex, array[right_index][0])

    # Draw the graph
    pos = nx.spring_layout(G)  # Define the layout
    nx.draw(G, pos, with_labels=True, node_size=1500, node_color="skyblue", font_size=12, font_weight="bold", arrowsize=20)
    plt.show()

# Example usage
data = [['I', 2], ['A', 5], ['E', 4], ['F', 1], ['T', 2], ['S', 3]]
draw_graph(data)
