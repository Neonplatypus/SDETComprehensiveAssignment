import csv

class ReadAndWriteData:
    def __init__(this, csvfile):
        this.data = this.read_csv_data(csvfile)

    def read_csv_data(this, csvfile):
        data = []
        with open(csvfile, 'r') as file:
            csv_reader = csv.DictReader(file)
            for row in csv_reader:
                data.append(row)
        return data

    def display_data(this):
        for row in this.data:
            print(f"Name: {row['Name']}, SkillSet: {row['SkillSet']}, Experience: {row['Experience']}")

if __name__ == "__main__":
    csvfile = "D:/Office Space/SDET_ComprehensiveAssignmentData/user_data - Sheet1.csv"
    data_reader = ReadAndWriteData(csvfile)
    data_reader.display_data()
