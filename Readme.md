## To open a tunnel to devcloud from local env

One way to allow the connection from the game-server to your response-server is to make an ssh tunnel, which allows remote
connections to map to local ports. In order to do that, you must enable sshd to listen to ip ports (basic is only localhost):

Edit /etc/ssh/sshd_config and add a line: 
``
GatewayPorts yes
``

then you need to restart sshd:

``
sudo systemctl restart sshd.service
``


When on local server, just open a terminal (git bash) and run this command: 
``
ssh -p 2222 -R 9000:localhost:1337 dc-user@<devcloud-name>
``

Now you can start the webserver (defaults to listen to port 1337), and hack away.

