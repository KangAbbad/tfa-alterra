echo "Program berjalan mulai $(date)"
echo "Jumlah argument yang dipassing: $# Process ID: $$"

for file in "$@"; do
	echo "Nama file $file"
	cat "$file" | grep foo > /dev/null
	if [[ "$?" -eq 0 ]]; then
		echo "Di file $file ada nih kata foo"
	else
		echo "Di file $file belum ada nih kata foo"
	fi
done
