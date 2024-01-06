Java Server.jar code to start non Java applications on servers intended only for Java.
Useful for cheap web applications running on Minecraft hosting :)

Typically MC servers operate in special MC containers with no way to install stuff like node.js, python, etc. You'll need to bring your own Linux executables along with any number of predownloaded dependencies. This demo works with node.js.
Could be extended to support multiple processes on different ports so you can split the bills with 3 other startups and have your nano silicon valley datacenter going.

Pros:
- super cheap
- prospect of having an entire startup powered on a cheapest MC server...

Cons:
- Often no SSL/https
- No Web hooks and other typical devop stuff
- Sketchy af
