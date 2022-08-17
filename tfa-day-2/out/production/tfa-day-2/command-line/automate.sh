automate() {
	mkdir -p "$1 $(date)/about_me/personal"
	touch "$1 $(date)/about_me/personal/facebook.txt"
	echo "https://www.facebook.com/$2" > "$1 $(date)/about_me/personal/facebook.txt"

	mkdir -p "$1 $(date)/about_me/professional"
	touch "$1 $(date)/about_me/professional/linkedin.txt"
	echo "https://www.linkedin.com/in/$3" > "$1 $(date)/about_me/professional/linkedin.txt"

	mkdir -p "$1 $(date)/my_friends"
	touch "$1 $(date)/my_friends/list_of_my_friends.txt"

	mkdir -p "$1 $(date)/my_system_info"
	touch "$1 $(date)/my_system_info/about_this_laptop.txt"
	printf "My username: $(whoami)\nWith host: $(uname -a)" > "$1 $(date)/my_system_info/about_this_laptop.txt"

	mkdir -p "$1 $(date)/my_system_info"
	touch "$1 $(date)/my_system_info/internet_connection.txt"
	echo "Connection to google:" >> "$1 $(date)/my_system_info/internet_connection.txt"
	PING forcesafesearch.google.com -c 3 >> "$1 $(date)/my_system_info/internet_connection.txt"
}
