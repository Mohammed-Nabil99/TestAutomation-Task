import pandas as pd
df=pd.read_csv('employees.csv')

df= df.drop_duplicates()
df['Age'] = df['Age'].astype(int)
conversion_rate = 50
df['Salary(EGP)'] = df['Salary(USD)'] * conversion_rate

average_age = df['Age'].mean()
median_salary = df['Salary(EGP)'].median()

male_count = df[df['Gender'] == 'M'].shape[0]
female_count = df[df['Gender'] == 'F'].shape[0]
ratio_male_to_female = male_count / female_count

print(f"Average Age: {average_age:.2f}")
print(f"Median Salary (EGP): {median_salary:.2f}")
print(f"Ratio of Male to Female Employees: {ratio_male_to_female:.2f}")

output_file_path = r'C:\Users\Mido\PycharmProjects\Task3-Python\Employees\modified_employees.csv'
df.to_csv(output_file_path, index=False)