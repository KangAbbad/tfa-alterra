echo "Program berjalan mulai $(date)";
echo "Jumlah argument yang dipassing: $# Process ID: $$";

for file in "$@"; do
	echo "Nama file $file";
	cat "$file" | grep foo;
done
